package com.koreait.dao;

import java.util.ArrayList;

import com.koreait.vo.EmployeeVO;
import com.koreait.vo.EtcSpendingVO;
import com.koreait.vo.NoticeVO;
import com.koreait.vo.OrderList;
import com.koreait.vo.OrderVO;
import com.koreait.vo.ProductVO;
import com.koreait.vo.UserVO;
import com.koreait.vo.WorkVO;

public interface MybatisDAO {

	// User //
	// USER 테이블에서 해당 id, pw를 가진 계정의 수 얻기
	int selectUserCount(UserVO userVO);

	
	
	// Product //
	// Product 테이블에서 해당 id를 가지며 count==1인 모든 data를 가져온다.
	ArrayList<ProductVO> selectExistProducts(String id);

	// Product 테이블에 data 한 건을 추가한다. code는 seq.nextval값 할당.
	void insertProduct(ProductVO productVO);//# expireDate를 String 형으로 수정

	// Product 테이블에서 해당 id와 code를 가진 행의 count를 수정한다.
	void updateProductCount(ProductVO productVO);
	
	// Product 테이블에서 해당 id를 가지며 count==0인 행들의 price 합을 가져온다.
	int selectRevenue(String id);
	
	
	
	// Employee //
	// Employee 테이블에서 해당 id를 가지는 모든 data를 가져온다.
	ArrayList<EmployeeVO> selectAllEmployees(String id);
	
	// Employee 테이블에서 해당 id, idx를 가진 data 한 건을 삭제한다.
	void deleteEmployee(EmployeeVO employeeVO);

	// Employee 테이블에 data 한 건을 추가한다.
	void insertEmployee(EmployeeVO employeeVO);
	
	
	// Work //
	// Work 테이블에서 해당 id를 가지는 행들의 pay 합을 가져온다.
	int selectWorkPaySum(String id);
	
	// Work 테이블에서 해당 id를 가지는 모든 행을 가져온다.
	ArrayList<WorkVO> selectAllWorks(String id);

	// Work 테이블에 vo 한 건을 저장한다.
	void insertWork(WorkVO workVO);
	
	
	// Order //
	// Order 테이블에 vo 한 건을 저장한다.
	void insertOrder(OrderVO orderVO);

	// Order 테이블에서 해당 id를 가지는 행들의 price 합을 가져온다.
	int selectOrderPriceSum(String id);

	// Order 테이블에서 해당 id를 가지는 모든 행을 가져온다.
	ArrayList<OrderVO> selectAllOrders(String id);
	
	
	
	// EtcSpending //
	// EtcSpending 테이블에서 해당 id를 가지는 행들의 price 합을 가져온다.
	int selectEtcPriceSum(String id);

	// EtcSpending 테이블에서 해당 id를 가지는 모든 행을 가져온다.
	ArrayList<EtcSpendingVO> selectAllEtcs(String id);

	// EtcSpending 테이블에 data 한 건을 추가한다.
	void insertEtc(EtcSpendingVO etcSpendingVO);


	
	// Notice //
	// Notice 테이블에서 최신에 입력된 행을 가져온다.
	NoticeVO selectRecentNotice();











	
	
	
}
