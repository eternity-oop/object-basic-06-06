package org.eternity.reservation.domain;

import org.eternity.generic.Money;

public class NoneDiscountPolicy extends DiscountPolicy {

    public NoneDiscountPolicy(Long id, DiscountCondition... conditions) {
        super(id, conditions);
    }

    public NoneDiscountPolicy(DiscountCondition... conditions) {
        super(null, conditions);
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
