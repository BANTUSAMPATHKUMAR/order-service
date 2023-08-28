package com.order.manage.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.manage.entity.OrdersEntity;
import com.order.manage.exception.OrderNotFound;
import com.order.manage.mapper.OrdersEntityMapper;
import com.order.manage.mapper.OrdersModelMapper;
import com.order.manage.model.OrdersModel;
import com.order.manage.repository.OrderDao;
import com.order.manage.service.OrderService;

@Service
public class OrderServiceImp implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private OrdersEntityMapper ordersEntityMapper;

	@Autowired
	private OrdersModelMapper ordersModelMapper;

	@Override
	public void createOrder(OrdersModel ordersModel) {
		orderDao.save(ordersEntityMapper.modelToOrdersEntity(ordersModel));
	}

	@Override
	public void updateOrder(OrdersModel ordersModel) {
		orderDao.save(ordersEntityMapper.modelToOrdersEntity(ordersModel));
	}

	@Override
	public void deleteByOrderId(int orderId) {
		orderDao.deleteById(orderId);
	}

	@Override
	public OrdersModel findByOrderId(int orderId) {
		OrdersModel ordersModel;
		Optional<OrdersEntity> ordersEntityOptional = orderDao.findById(orderId);
		if (ordersEntityOptional.isPresent()) {
			ordersModel = ordersModelMapper.entityToOrdersModel(ordersEntityOptional.get());
		} else {
			throw new OrderNotFound("ordersEntity is not found for given orderId" + orderId);
		}
		return ordersModel;
	}

}
