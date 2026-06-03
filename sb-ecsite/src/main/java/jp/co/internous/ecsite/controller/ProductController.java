package jp.co.internous.ecsite.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jp.co.internous.ecsite.dao.ProductDao;
import jp.co.internous.ecsite.dto.ProductDto;

/**
* 商品情報を制御するコントローラークラス
* 商品一覧画面、商品詳細画面の表示を行う
*/
@Controller
public class ProductController {

	// productDao という変数名で ProductDao インターフェースを利用するための宣言
    @Autowired
    private ProductDao productDao;


	// 全商品情報を取得して商品一覧画面を表示する
    //
	@GetMapping("/ecsite/product")
	public ModelAndView showProductList(ModelAndView mav) {
		// 商品テーブルから全ての商品情報を取得する
		ArrayList<ProductDto>productList = productDao.getAllProducts();

		// レスポンスに検索した全商品の情報を追加する
        mav.addObject("productList",productList);
		// レスポンスとして次に表示させるHTMLファイル名を指定する
		mav.setViewName("product_list");
		return mav;
	}

	// １件の商品情報を取得して商品詳細画面を表示する
	//
	@GetMapping("/ecsite/detail")
	//
	public ModelAndView showDetail(@RequestParam("productId")int productId, ModelAndView mav) {
		//
       ProductDto product = productDao.getProductByProductId(productId);
		//
       mav.addObject("product",product);
		//
       mav.setViewName("detail");
		return mav;
	}

}
