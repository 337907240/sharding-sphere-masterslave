/*
 * ............................................. 
 * 
 * 				    _ooOoo_ 
 * 		  	       o8888888o 
 * 	  	  	       88" . "88 
 *                 (| -_- |) 
 *                  O\ = /O 
 *              ____/`---*\____ 
 *               . * \\| |// `. 
 *             / \\||| : |||// \ 
 *           / _||||| -:- |||||- \ 
 *             | | \\\ - /// | | 
 *            | \_| **\---/** | | 
 *           \  .-\__ `-` ___/-. / 
 *            ___`. .* /--.--\ `. . __ 
 *        ."" *< `.___\_<|>_/___.* >*"". 
 *      | | : `- \`.;`\ _ /`;.`/ - ` : | | 
 *         \ \ `-. \_ __\ /__ _/ .-` / / 
 *======`-.____`-.___\_____/___.-`____.-*====== 
 * 
 * ............................................. 
 *              佛祖保佑 永无BUG 
 *
 * 佛曰: 
 * 写字楼里写字间，写字间里程序员； 
 * 程序人员写程序，又拿程序换酒钱。 
 * 酒醒只在网上坐，酒醉还来网下眠； 
 * 酒醉酒醒日复日，网上网下年复年。 
 * 但愿老死电脑间，不愿鞠躬老板前； 
 * 奔驰宝马贵者趣，公交自行程序员。 
 * 别人笑我忒疯癫，我笑自己命太贱； 
 * 不见满街漂亮妹，哪个归得程序员？
 *
 * 北纬30.√  154518484@qq.com
 */
package com.github.service;

import com.github.mapper.OrderItemMapper;
import com.github.mapper.OrderMapper;
import com.github.model.Order;
import com.github.model.OrderItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class OrderService {

    @Resource private OrderMapper orderMapper;
    @Resource private OrderItemMapper orderItemMapper;

    @Transactional
    public void demo() {

        System.err.println(orderMapper.get(1L));

        Order order = new Order();
        order.setUserId(51);
        order.setStatus("INSERT_TEST");
        orderMapper.insert(order);
        System.err.println(order);

        System.err.println(orderMapper.get(order.getOrderId()));



        OrderItem item = new OrderItem();
        item.setOrderId(order.getOrderId());
        item.setUserId(51);
        orderItemMapper.insert(item);

    }

    public void demo1() {

        orderMapper.createIfNotExistsTable();
        orderItemMapper.createIfNotExistsTable();

        orderMapper.truncateTable();
        orderItemMapper.truncateTable();

        List<Long> orderIds = new ArrayList<>(10);
        System.out.println("1.Insert--------------");

        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setUserId(51);
            order.setStatus("INSERT_TEST");
            orderMapper.insert(order);

            long orderId = order.getOrderId();
            orderIds.add(orderId);

            OrderItem item = new OrderItem();
            item.setOrderId(orderId);
            item.setUserId(51);
            orderItemMapper.insert(item);
        }

        System.out.println(orderItemMapper.selectAll());

//        System.out.println("2.Delete--------------");
//        for (Long each : orderIds) {
//            orderMapper.delete(each);
//            orderItemMapper.delete(each);
//        }
//        System.out.println(orderItemMapper.selectAll());
//
//        orderItemMapper.dropTable();
//        orderMapper.dropTable();
    }

}

