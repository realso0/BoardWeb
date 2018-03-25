package com.springbook.ioc.injection;

import java.util.List;
import java.util.Set;

public class CollectionBean {
	private Set<String> addressList;
	
	public CollectionBean() {
		System.out.println("===> CollectionBean 객체 생성");
	}
	
	public void setAddressSet(Set<String> addressList) {
		System.out.println("===> setAddressList() 호출");
		this.addressList=addressList;
	}
	
	public Set<String> getAddressSet() {
		return addressList;
	}
}
