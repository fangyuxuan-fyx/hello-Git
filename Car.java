package gdpu.javaweb.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Car entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "car", catalog = "test1")

public class Car implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private Category category;
	private Goods goods_id;

	private String userName;
	private String goodsName;
	private Integer goodsPrize;
	private Integer goodNumber;

	// Constructors

	/** default constructor */
	public Car() {
	}

	/** minimal constructor */
	public Car(Integer orderId, String userName) {
		this.orderId = orderId;
		this.userName = userName;
	}

	/** full constructor */
	public Car(Integer orderId, Category category, Goods goods_id,String userName, String goodsName,
			Integer goodsPrize,Integer goodNumber) {
		this.orderId = orderId;
		this.category = category;
		this.goods_id=goods_id;
		
		this.userName = userName;
		this.goodsName = goodsName;
		this.goodsPrize = goodsPrize;
		this.goodNumber = goodNumber;
		
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "orderID", unique = true, nullable = false)

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "goods_id")

	public Goods getGoods_id() {
		return this.goods_id;
	}

	public void setGoods_id(Goods goods_id) {
		this.goods_id = goods_id;
	}

	@Column(name = "user_name")

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "goods_name")

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	@Column(name = "goods_prize")

	public Integer getGoodsPrize() {
		return this.goodsPrize;
	}

	public void setGoodsPrize(Integer goodsPrize) {
		this.goodsPrize = goodsPrize;
	}

	@Column(name = "good_number")

	public Integer getGoodNumber() {
		return this.goodNumber;
	}

	public void setGoodNumber(Integer goodNumber) {
		this.goodNumber = goodNumber;
	}
}

































  <tr>
       
		  <td class="font1" colspan="8" style="font-size:24px;font-weight:bold;text-align:right; height:30px;"> 
	   <div style=" margin-right: 60px; margin-top: 15px;" align="center">
	   	 	<button class=" layui-btn layui-btn-danger " id="firstPage" >首页</button>
	   		<button class="  layui-btn layui-btn-normal " id="setPreviousPage">上一页</button>
	   		<span id="page_size"></span>
	   		<button class="page  layui-btn layui-btn-normal " id="setNextPage">下一页</button>
			<button class="page layui-btn layui-btn-danger " id="endPage" >末页</button>
			</div>
	   </td>
	       </tr> 
	   <tr>
	       <!-- 分页下半部 -->
	
	
	   <td class="font1" colspan="8" style="font-size:18px;font-weight:bold;text-align:right; height:30px;"> 
	   <div style=" margin-right: 60px; margin-top: 10px;" align="right">
			&nbsp;&nbsp;&nbsp;&nbsp;<span>总条数:</span><span id="totalCount"></span>
			<label>当前页:</label> <span id="currentPage">1</span>/<span id="totalPage"></span>
		&nbsp;&nbsp;&nbsp;&nbsp;跳到第<input type="number" id="goNumber"  style="width: 60px;height: 24px;" min="1" value="" max="" /> 页
		<button id="goPage" class="page  layui-btn layui-btn-normal" style="height: 24px;font-size:18px;padding-right:8px; padding-left:8px;background-color:#23689b;line-height:24px;">
		前往</button>&nbsp;&nbsp;&nbsp;&nbsp;每页显示 
		<select id="pageSize" name="pageSize" style="width: 60px;height: 24px;">
			<option ${pageSize==8?'selected=selected':''} value="8">8</option>
			<option ${pageSize==15?'selected=selected':''} value="15">15</option>
			<option ${pageSize==50?'selected=selected':''} value="50">50</option>
		</select> 条<button class="page  layui-btn" style="height: 24px;font-size:18px;padding-right:8px; padding-left:8px;background-color:#23689b;line-height:24px;" id="changeSize">确定</button>
		</div> 
	   </td>
	       </tr> 