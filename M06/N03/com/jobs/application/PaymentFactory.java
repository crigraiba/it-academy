package com.jobs.application;

import com.jobs.domain.IPaymentRate;

public class PaymentFactory {
	
	public static IPaymentRate createPaymentRateBoss() {
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*1.5; // salaryPerMonth*(1+0.5)
			}
		};
	}
	
	public static IPaymentRate createPaymentRateManager() {
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*1.1; // salaryPerMonth*(1+0.1)
			}
		};
	}
	
	public static IPaymentRate createPaymentRateSeniorEmployee() {
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*0.95; // salaryPerMonth*(1-0.05)
			}
		};
	}
	
	public static IPaymentRate createPaymentRateMidEmployee() {
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*0.9; // salaryPerMonth*(1-0.1)
			}
		};
	}
	
	public static IPaymentRate createPaymentRateJuniorEmployee() {
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*0.85; // salaryPerMonth*(1-0.15)
			}
		};
	}
	
}
