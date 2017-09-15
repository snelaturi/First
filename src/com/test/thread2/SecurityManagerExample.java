package com.test.thread2;

import java.security.Permission;

import com.test.Util;

public class SecurityManagerExample {

	public static void main(String[] args) {

		System.out.println("A");
		Util.sleep(5000);

		MySecurityManager msm = new MySecurityManager();
		// msm.checkPe
		System.setSecurityManager(msm);

		System.exit(0);

		System.out.println("B");

	}

}

class MySecurityManager extends SecurityManager {
	@Override
	public void checkExit(int status) {
		System.out.println("checking permissions ");
		throw new SecurityException();
	}

	@Override
	public void checkPermission(Permission perm) {
		System.out.println("checking permissions11 ");
		if ("exitVM".equals(perm.getName())) {
			throw new SecurityException();
		}
	}
}
