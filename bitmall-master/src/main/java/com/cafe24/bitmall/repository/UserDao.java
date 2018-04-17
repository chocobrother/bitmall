package com.cafe24.bitmall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.BuyVo;
import com.cafe24.bitmall.vo.CartVo;
import com.cafe24.bitmall.vo.CategoryVo;
import com.cafe24.bitmall.vo.FaqVo;
import com.cafe24.bitmall.vo.OrderProductVo;
import com.cafe24.bitmall.vo.ProductVo;
import com.cafe24.bitmall.vo.UserVo;
import com.cafe24.mysite.exception.UserDaoException;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;

	public boolean insert(UserVo vo) {

		int count = sqlSession.insert("user.insert", vo);

		return count == 1;
	}

	public UserVo get(UserVo vo) throws UserDaoException {

		UserVo result = sqlSession.selectOne("user.getByEmailAndPassword", vo);

		return result;
	}

	public List<UserVo> getlist() throws UserDaoException {

		List<UserVo> list = sqlSession.selectList("user.getlist");

		return list;
	}

	public Long getcount() {

		Long count = sqlSession.selectOne("user.getcount");

		return count;
	}

	public boolean update(UserVo vo) {

		int count = sqlSession.update("user.update", vo);

		return count == 1;
	}

	////////////// 카테고리
	public CategoryVo categoryadd(CategoryVo vo) {

		int count = sqlSession.insert("user.categoryadd", vo);

		System.out.println("리턴값을 받아야지 다오임");

		return vo;
	}

	public List<CategoryVo> getCategory() {

		List<CategoryVo> list = sqlSession.selectList("user.getcategory");

		return list;
	}

	public int categorydelete(Long no) {

		int count = sqlSession.delete("user.categorydelete", no);

		return count;
	}

	////////////// 상품
	public boolean addproduct(ProductVo vo) {

		int count = sqlSession.insert("user.addproduct", vo);

		return count == 1;
	}

	public List<ProductVo> getProduct() {

		List<ProductVo> list = sqlSession.selectList("user.getproduct");

		return list;
	}

	public boolean productDelete(Long no) {

		int count = sqlSession.delete("user.productdelete", no);

		return count == 1;
	}

	public ProductVo getProductByNo(Long no) {

		ProductVo vo = new ProductVo();

		vo = sqlSession.selectOne("user.getproductbyno", no);

		return vo;
	}

	public String getImage(String name) {

		String ss = sqlSession.selectOne("user.getimage", name);

		return ss;
	}

	public BuyVo addbuy(BuyVo vo) {

		int count = sqlSession.insert("user.addbuy", vo);

		return vo;
	}

	public boolean addorder(OrderProductVo vo) {

		int count = sqlSession.insert("user.addorder", vo);

		return count == 1;
	}

	public List<BuyVo> getbuylist(Long no) {

		List<BuyVo> list = sqlSession.selectList("user.getbuylist", no);

		return list;
	}

	public BuyVo getbuyinfo(Long no) {

		BuyVo vo = sqlSession.selectOne("user.getbuyinfo", no);

		return vo;
	}

	public boolean addcart(CartVo vo) {

		int count = sqlSession.insert("user.addcart", vo);

		return count == 1;
	}

	public List<CartVo> cartlist(Long no) {

		List<CartVo> list = sqlSession.selectList("user.cartlist", no);

		return list;
	}

	public boolean deletecart(Long no) {

		int count = sqlSession.delete("user.deletecart", no);

		return count == 1;
	}

	public boolean cartalldelete() {

		int count = sqlSession.delete("user.cartalldelete");

		return count == 1;
	}

	public List<ProductVo> getProlistByNo(Long no) {

		List<ProductVo> list = sqlSession.selectList("user.getprolistbyno", no);

		return list;
	}

	
	public List<BuyVo> allbuylist() {

		List<BuyVo> list = sqlSession.selectList("user.allbuylist");

		return list;
	}
	
	public BuyVo buylistbyno(Long no) {

		BuyVo vo = sqlSession.selectOne("user.buylistbyno", no);

		return vo;
	}
	
	public Long getproductcount() {

		Long count = sqlSession.selectOne("user.getproductcount");

		return count;
	}
	
	public Long getcategorycount() {

		Long count = sqlSession.selectOne("user.getcategorycount");

		return count;
	}

	public Long getbuycount() {

		Long count = sqlSession.selectOne("user.getbuycount");

		return count;
	}
	
	
	public List<CartVo> pronumbycart(Long no) {

		List<CartVo> list = sqlSession.selectList("user.pronumbycart", no);

		return list;
	}
	

	public List<BuyVo> jumunlist(Long no) {

		List<BuyVo> list = sqlSession.selectList("user.jumunlist", no);

		return list;
	}
	
	public List<BuyVo> alljumunlist() {

		List<BuyVo> list = sqlSession.selectList("user.alljumunlist");

		return list;
	}
	
	
public boolean jumundelete(Long no) {
		
		int count = sqlSession.delete("user.jumundelete", no);
		
		return count==1;
	}


public boolean orderjumundelete(Long no) {
	
	int count = sqlSession.delete("user.orderjumundelete", no);
	
	return count==1;
}

	
	
	public List<CartVo> cartjoinpro(Long no) {

		List<CartVo> list = sqlSession.selectList("user.cartjoinpro", no);

		return list;
	}
	
	public List<FaqVo> getfaqlist() {

		List<FaqVo> list = sqlSession.selectList("user.getfaqlist");

		return list;
	}
	
	public boolean addfaq(FaqVo vo) {
		
		int count = sqlSession.insert("user.addfaq", vo);
		
		return count==1;
	}
	
	
public boolean deletefaq(Long no) {
		
		int count = sqlSession.delete("user.deletefaq", no);
		
		return count==1;
	}

public boolean updatefaq(FaqVo vo) {
	
	int count = sqlSession.update("user.updatefaq", vo);
	
	return count==1;
}

public FaqVo faqbyno(Long no) {

	FaqVo vo = sqlSession.selectOne("user.faqbyno",no);

	return vo;
}

public boolean updateproduct(ProductVo vo) {
	
	int count = sqlSession.update("user.updateproduct", vo);
	
	return count==1;
}


}
