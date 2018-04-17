package com.cafe24.bitmall.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.bitmall.repository.UserDao;
import com.cafe24.bitmall.vo.BuyVo;
import com.cafe24.bitmall.vo.CartVo;
import com.cafe24.bitmall.vo.CategoryVo;
import com.cafe24.bitmall.vo.FaqVo;
import com.cafe24.bitmall.vo.OrderProductVo;
import com.cafe24.bitmall.vo.ProductVo;
import com.cafe24.bitmall.vo.UserVo;
import com.cafe24.mysite.exception.UserDaoException;


@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	private static String SAVE_PATH = "/uploads";
	private static String PREFIX_URL = "/uploads/";
	
	public String restore(MultipartFile multipartFile) {

		if(multipartFile ==null || multipartFile.getOriginalFilename().equals("")) {
			return null;
		}
		
		String url = "";

		try {
			String originFileName = multipartFile.getOriginalFilename();

			// 파일확장자명은 ----.png 이기 때문에 뒤에서 부터 찾음

			String extName = originFileName.substring(originFileName.lastIndexOf("."), originFileName.length());

			Long size = multipartFile.getSize();

			String saveFileName = genSaveFileName(extName);

			System.out.println("############" + originFileName);
			System.out.println("############" + extName);
			System.out.println("############" + size);
			System.out.println("############" + saveFileName);

			writeFile(multipartFile, saveFileName);

			url = PREFIX_URL + saveFileName;

		} catch (IOException ex) {

			throw new RuntimeException(ex);
		}

		return url;

	}

	private void writeFile(MultipartFile multipartFile, String saveFileName) throws IOException {

		byte[] fileData = multipartFile.getBytes();

		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFileName);

		fos.write(fileData);

		fos.close();

	}

	private String genSaveFileName(String extName) {

		String fileName = "";

		Calendar calendar = Calendar.getInstance();

		fileName += calendar.get(Calendar.YEAR);
		fileName += calendar.get(Calendar.MONTH);
		fileName += calendar.get(Calendar.DATE);
		fileName += calendar.get(Calendar.HOUR);
		fileName += calendar.get(Calendar.MINUTE);
		fileName += calendar.get(Calendar.SECOND);
		fileName += calendar.get(Calendar.MILLISECOND);
		fileName += extName;

		return fileName;

	}
	
	
	
	
	public void join(UserVo vo) {
		userDao.insert(vo);
	}
	
	public UserVo getUser(UserVo vo) throws UserDaoException {
		return userDao.get(vo);
	}

	
	
	public List<UserVo> getlist() throws UserDaoException {
		
		List<UserVo> list = userDao.getlist();
		
		return list;
	}
	

	
	
	public Long getcount() {
			
			Long count = userDao.getcount();
			
			return count;
		}
	
		
	public void update(UserVo vo) {
		userDao.update(vo);
	}
	
	
	
	public CategoryVo categoryadd(CategoryVo vo) {
		
		
		System.out.println("서비스에서 vo확인 하기" + vo);
			
		userDao.categoryadd(vo);
		
		System.out.println("리턴 Vo 받아야지 서비스임");
		
			return vo;
		}
	
	public List<CategoryVo> getCategory()

	{

		List<CategoryVo> list = userDao.getCategory();

		return list;
	}

	public void categorydelete(Long no) {
		userDao.categorydelete(no);
	}
	
	///////////상품
	public void addproduct(ProductVo vo) {
		userDao.addproduct(vo);
	}
	
	public List<ProductVo> getProduct()

	{

		List<ProductVo> list = userDao.getProduct();

		return list;
	}
	
	public void productDelete(Long no) {
		userDao.productDelete(no);
	}
	
	public ProductVo getProductByNo(Long no) throws UserDaoException {
		return userDao.getProductByNo(no);
	}
	
	public String getImage(String name) throws UserDaoException {
		return userDao.getImage(name);
	}

	///////////////////구매
	
	public BuyVo addbuy(BuyVo vo) {
		userDao.addbuy(vo);
		
		return vo;
	}
	
	public void addorder(OrderProductVo vo) {
		userDao.addorder(vo);
	}
	
	public List<BuyVo> getbuylist(Long no){
		
		List<BuyVo> list = userDao.getbuylist(no);
		
		return list;
		
	}
	
	public BuyVo getbuyinfo(Long no){
		
		BuyVo vo = userDao.getbuyinfo(no);
		
		
		
		return vo;
		
	}
	
	public void addcart(CartVo vo) {
		userDao.addcart(vo);
	}

public List<CartVo> cartlist(Long no){
		
		List<CartVo> list = userDao.cartlist(no);
		
		return list;
		
	}
public void deletecart(Long no) {
	userDao.deletecart(no);
}

public void cartalldelete() {
	userDao.cartalldelete();
}

public List<ProductVo> getProlistByNo(Long no){
	
	List<ProductVo> list = userDao.getProlistByNo(no);
	
	return list;
	
}	

public List<BuyVo> allbuylist(){
	
	List<BuyVo> list = userDao.allbuylist();
	
	return list;
	
}	

public BuyVo buylistbyno(Long no){
	
	BuyVo vo = userDao.buylistbyno(no);
	
	return vo;
	
}	

public Long getproductcount() {
 Long no = userDao.getproductcount();
 
 return no;
}

public Long getcategorycount() {
	 Long no = userDao.getcategorycount();
	 
	 return no;
	}
public Long getbuycount() {
	 Long no = userDao.getbuycount();
	 
	 return no;
	}

public List<CartVo> pronumbycart(Long no){
	
	List<CartVo> list = userDao.pronumbycart(no);
	
	return list;
	
}	

public List<BuyVo> jumunlist(Long no){
	
	List<BuyVo> list = userDao.jumunlist(no);
	
	return list;
	
}	

public List<BuyVo> alljumunlist(){
	
	List<BuyVo> list = userDao.alljumunlist();
	
	return list;
	
}	

public void jumundelete(Long no) {
	userDao.jumundelete(no);
}

public void orderjumundelete(Long no) {
	userDao.orderjumundelete(no);
}



public List<CartVo> cartjoinpro(Long no){
	
	List<CartVo> list = userDao.cartjoinpro(no);
	
	return list;
	
}	

public List<FaqVo> getfaqlist( ){
	
	List<FaqVo> list = userDao.getfaqlist();
	
	return list;
	
}	

public void addfaq(FaqVo vo) {
	userDao.addfaq(vo);
}

public void deletefaq(Long no) {
	userDao.deletefaq(no);
}

public void updatefaq(FaqVo vo) {
	userDao.updatefaq(vo);
}

public FaqVo faqbyno(Long no ){
	
	FaqVo vo = userDao.faqbyno(no);
	
	return vo;
	
}	

public void updateproduct(ProductVo vo) {
	userDao.updateproduct(vo);
}

}
