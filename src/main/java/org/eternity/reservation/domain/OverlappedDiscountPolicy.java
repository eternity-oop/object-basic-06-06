package org.eternity.reservation.domain;

import org.eternity.generic.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverlappedDiscountPolicy extends DiscountPolicy {
    private List<DiscountPolicy> policies = new ArrayList<>();

    public OverlappedDiscountPolicy(DiscountPolicy ... policies) {
        super(null, (screening -> true));
        this.policies = Arrays.asList(policies);
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        Money result = Money.ZERO;

        for(DiscountPolicy each : policies) {
            result = result.plus(each.calculateDiscount(screening));
        }

        return result;
    }
}
