package com.koreait.project_4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.dao.MybatisDAO;
import com.koreait.vo.EmployeeList;
import com.koreait.vo.EmployeeVO;
import com.koreait.vo.EtcSpendingList;
import com.koreait.vo.EtcSpendingVO;
import com.koreait.vo.NoticeVO;
import com.koreait.vo.OrderList;
import com.koreait.vo.OrderVO;
import com.koreait.vo.ProductList;
import com.koreait.vo.ProductVO;
import com.koreait.vo.SpendingList;
import com.koreait.vo.SpendingVO;
import com.koreait.vo.UserVO;
import com.koreait.vo.WorkList;
import com.koreait.vo.WorkVO;

@Controller
public class HomeController {

	@Autowired
	private SqlSession sqlSession;
	
	// 메소드
	// 테이블의 char 영역 크기에 맞게 문자열을 재조정하는 함수.
	// where 절에서 문자열 일치 여부를 확인할 때 중요
	public String resize(String str, int size) {
		int currSize=str.length();
		
		for(int i=0; i<size-currSize; i++)
			str+=" ";
		return str;
	}
	
	
	//////////////////////////////////////////////////////////////////////
	
	// 컨트롤러
	
	@RequestMapping("/")
	public String home(Model model,HttpSession session) {

		return "redirect:login";
	}
	
	
	@RequestMapping("/login")
	public String login(Model model,HttpSession session) {
		// session을 사용해 로그인 상태를 유지한다.
		// 이미 로그인 되었다면 main 화면으로
		if(session.getAttribute("login")=="True") {
			return "redirect:main";
		}
		return "login";
	}
	

	
	@RequestMapping("/loginOK")
	public String loginOK(HttpSession session, HttpServletRequest request, Model model, UserVO userVO) {
		MybatisDAO mapper = sqlSession.getMapper(MybatisDAO.class);

		String id=userVO.getId();
		String pw=userVO.getPw();
		
		// id 필드가 20Byte이므로 보정
		userVO.setId(resize(id,20));
		userVO.setPw(resize(pw,20));
		int count=mapper.selectUserCount(userVO);
		
		if(count==1) {
			// 세션에 계정 정보 넣기
			session.setAttribute("id", id);
			//session.setAttribute("pw", pw);
			session.setAttribute("login", "True");
			return "redirect:main";
		}
		else
			return "redirect:login";
				
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, HttpServletRequest request, Model model) {
		
		session.removeAttribute("id");
		//session.removeAttribute("pw");
		session.removeAttribute("login");
		
		return "redirect:login";
	}
	
	
	@RequestMapping("/main")
	public String main(HttpSession session,HttpServletRequest request,Model model) {
		MybatisDAO mapper = sqlSession.getMapper(MybatisDAO.class);
		if(session.getAttribute("login")!="True") return "redirect:login";
		
		NoticeVO noticeVO=mapper.selectRecentNotice();
		if(noticeVO==null) {
			noticeVO=new NoticeVO();
			Date date=new Date();
			date.setTime(System.currentTimeMillis());
			noticeVO.setDatetime(date);
			noticeVO.setContent("공지사항이 없습니다.");
		}
		
		model.addAttribute("notice", noticeVO);
		return "main";
	}
	
	
	// 재고 관리 창으로 이동
	@RequestMapping("/product")
	public String product(HttpSession session, HttpServletRequest request,Model model) {
		MybatisDAO mapper = sqlSession.getMapper(MybatisDAO.class);

		if(session.getAttribute("login")!="True") return "redirect:login";
		String id=session.getAttribute("id").toString();
		
		
		// 물품 목록(존재하는 것만)을 테이블에서 꺼내기
		ProductList list=new ProductList(); 
		list.setList(mapper.selectExistProducts(resize(id, 20)));
		
		// 물품 목록 보내기
		model.addAttribute("productList", list);
		return "product";
	}
	
	// 주문시 물품 추가
	// 커맨드객체 2개 사용 가능한가? 가능하다고 가정하고 코딩
	@RequestMapping("/productAdd")
	public String productAdd(HttpSession session, HttpServletRequest request,Model model, OrderVO orderVO, ProductVO productVO) {
		MybatisDAO mapper = sqlSession.getMapper(MybatisDAO.class);
		
		String id=session.getAttribute("id").toString();
		
		
		// 주문 내역을 테이블에 입력
		orderVO.setId(id);
		mapper.insertOrder(orderVO);
		
		

		// 물품을 테이블에 추가
		int price=Integer.parseInt(request.getParameter("sellPrice"));
		String expDate=request.getParameter("expireDate1");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date expireDate=null;
		try { expireDate = sdf.parse(expDate); } catch (ParseException e) {}

		for(int i=0; i<orderVO.getNum(); i++) {
			//id, name, code, price, expireDate, count
			ProductVO vo=new ProductVO();
			vo.setId(id);
			vo.setName(productVO.getName());
			vo.setPrice(price);
			vo.setExpireDate(expireDate);
			vo.setCount(1);
			mapper.insertProduct(vo);
		}

		return "redirect:product";
	}	
	
	
	// 물품 판매
	@RequestMapping("/productSell")
	public String productSell(HttpSession session, HttpServletRequest request,Model model) {
	
		// 판매된 물품 : count를 0로 바꾼다.
		request.setAttribute("count", 0);
		return "forward:productCountChange";

	}	
	
	// 물품 폐기
	@RequestMapping("/productDispose")
	public String productDispose(HttpSession session, HttpServletRequest request,Model model) {
		
		// 폐기된 물품 : count를 -1로 바꾼다.
		request.setAttribute("count", -1);
		return "forward:productCountChange";
	}
	
	
	// 물품 count 필드값 변경
	@RequestMapping("/productCountChange")
	public String productCountChange(HttpSession session, HttpServletRequest request,Model model) {
		MybatisDAO mapper = sqlSession.getMapper(MybatisDAO.class);
		
		String id=session.getAttribute("id").toString();

		// View의 checkbox에서 code 정보들이 넘어옴
		String[] codes=request.getParameterValues("code");
		if(codes==null) return "redirect:product";
		
		int count=(Integer) request.getAttribute("count");
		
		// 해당 물품들의 count 필드값을 변경
		for(String code:codes) {
			ProductVO productVO=new ProductVO();
			productVO.setId(resize(id,20));
			productVO.setCode(resize(code,20));
			productVO.setCount(count);//
			mapper.updateProductCount(productVO);
		}
		
		return "redirect:product";
	}	
	
	
	
	
	
	// 수익 지출 창으로 이동
	@RequestMapping("/profit")
	public String sales(HttpSession session, HttpServletRequest request, Model model) {
		MybatisDAO mapper = sqlSession.getMapper(MybatisDAO.class);
		
		if(session.getAttribute("login")!="True") return "redirect:login";
		String id=session.getAttribute("id").toString();
		id=resize(id, 20);
		
		/*
		// 판매수익 
		int revenue=mapper.selectRevenue(id);
		model.addAttribute("revenue", revenue);
		
		// 지출액
		int orderCost=mapper.selectOrderPriceSum(id);
		int salary=mapper.selectWorkPaySum(id);
		int etcCost=mapper.selectEtcPriceSum(id);
		int spending=orderCost+salary+etcCost;
		model.addAttribute("spending", spending);
		
		// 순이익
		int income=revenue-spending;
		model.addAttribute("income", income);
		*/
		
		int revenue = 0;
		int spending = 0;
		int income = 0;
		
		
		// 지출 관련 테이블을 전부 읽어서
		// 하나의 list로 합치고 model에 넣기
		SpendingList list=new SpendingList();
		
		// Order 가져오기
		OrderList ol=new OrderList();
		ol.setList(mapper.selectAllOrders(id));
		for(OrderVO vo:ol.getList()) {
			SpendingVO s=new SpendingVO();
			s.setItem("주문");
			s.setName(vo.getName().trim());
//			etc 개수
			s.setEtc(vo.getNum());
			s.setPrice(vo.getPrice());
			
//			수입 / 지출 금 정의 
			s.setIncome(0);
			s.setSpending(vo.getPrice() * vo.getNum());
			
			revenue += 0;
			spending += vo.getPrice() * vo.getNum();
			
			s.setDatetime(vo.getDatetime());
			list.getList().add(s);
		}
		// Work 가져오기
		WorkList wl=new WorkList();
		wl.setList(mapper.selectAllWorks(id));
		for(WorkVO vo:wl.getList()) {
			SpendingVO s=new SpendingVO();
			s.setItem("시급");
//			s.setName("시급("+vo.getName().trim()+", "+(int)vo.getTime()+"시간)");
			s.setName(vo.getName().trim());
//			일한 시간
			s.setEtc((int)vo.getTime());
			s.setPrice(vo.getPay());
			
			s.setIncome(0);
			s.setSpending(vo.getPay() * (int)vo.getTime());
			
			revenue += 0;
			spending += vo.getPay() * (int)vo.getTime();
			
			s.setDatetime(vo.getDatetime());
			
			list.getList().add(s);
		}		
		// EtcSpending 가져오기
		EtcSpendingList el=new EtcSpendingList();
		el.setList(mapper.selectAllEtcs(id));
		for(EtcSpendingVO vo:el.getList()) {
			SpendingVO s=new SpendingVO();
			s.setItem("기타지출");
			s.setName(vo.getName().trim());
			s.setPrice(vo.getPrice());
			s.setDatetime(vo.getDatetime());
			
			s.setEtc(1);
			s.setIncome(0);
			s.setSpending(vo.getPrice());
			
			revenue += 0;
			spending += vo.getPrice();
			
			list.getList().add(s);
		}
		
		// 정렬해서 model에 넣음
		list.getList().sort(null);
		model.addAttribute("spendingList", list);
		
		model.addAttribute("revenue", revenue);
		model.addAttribute("spending", spending);
		model.addAttribute("income", revenue - spending);
		
		return "profit";
	}

	
	// 기타지출 입력
	@RequestMapping("/etcInsert")
	public String etcInsert(HttpSession session, HttpServletRequest request, Model model, EtcSpendingVO etcSpendingVO) {
		MybatisDAO mapper = sqlSession.getMapper(MybatisDAO.class);
		
		String id=session.getAttribute("id").toString();
		
		etcSpendingVO.setId(id);
		// 기타지출내역 입력
		mapper.insertEtc(etcSpendingVO);
		
		
		return "redirect:profit";
	}
	
	
	
	// 직원 창으로 이동
	@RequestMapping("/employee")
	public String employee(HttpSession session, HttpServletRequest request, Model model) {
		MybatisDAO mapper = sqlSession.getMapper(MybatisDAO.class);
		
		if(session.getAttribute("login")!="True") return "redirect:login";
		String id=session.getAttribute("id").toString();
		
		EmployeeList list=new EmployeeList();
		// 직원 목록 가져오기		
		list.setList(mapper.selectAllEmployees(resize(id,20)));
		model.addAttribute("employeeList", list);
		
		return "employee";
	}
	
	// 직원 추가
	@RequestMapping("/employeeAdd")
	public String employeeAdd(HttpSession session, HttpServletRequest request, Model model, EmployeeVO employeeVO) {
		MybatisDAO mapper = sqlSession.getMapper(MybatisDAO.class);
		
		String id=session.getAttribute("id").toString();
		
		employeeVO.setId(id);
		// 직원 추가
		mapper.insertEmployee(employeeVO);
		
		return "redirect:employee";
	}
	
	// 직원 삭제
	@RequestMapping("/employeeDelete")
	public String employeeDelete(HttpSession session, HttpServletRequest request, Model model, EmployeeVO employeeVO) {
		MybatisDAO mapper = sqlSession.getMapper(MybatisDAO.class);
		
		String id=session.getAttribute("id").toString();
		
		employeeVO.setId(resize(id,20));
		// 해당 id와 idx를 가진 직원 삭제
		mapper.deleteEmployee(employeeVO);
		
		return "redirect:employee";
	}
	
	// 직원 시급 주기
	@RequestMapping("/employeePay")
	public String employeePay(HttpSession session, HttpServletRequest request, Model model, EmployeeVO employeeVO) {
		MybatisDAO mapper = sqlSession.getMapper(MybatisDAO.class);
		// idx, name, wage, time이 넘어옴
		
		String id=session.getAttribute("id").toString();
		int time=Integer.parseInt(request.getParameter("time"));
		int pay=employeeVO.getWage()*time;
		
		WorkVO workVO=new WorkVO();
		workVO.setId(id);
		workVO.setIdx(employeeVO.getIdx());
		workVO.setName(employeeVO.getName());
		workVO.setTime(time);
		workVO.setPay(pay);
		
		// 직원 업무량 기록
		mapper.insertWork(workVO);
		
		return "redirect:employee";
	}
		
	
	
}

















