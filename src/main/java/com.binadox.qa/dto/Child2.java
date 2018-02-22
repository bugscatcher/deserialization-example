package com.binadox.qa.dto;

public class Child2 extends AbstractClass {
    private InnerChild2[] innerChild2s;

    public InnerChild2[] getInnerChild2s() {
        return innerChild2s;
    }

    public void setInnerChild2s(InnerChild2[] innerChild2s) {
        this.innerChild2s = innerChild2s;
    }

    private static class InnerChild2 {
        private Integer integer;
        private Long aLong;

        public Integer getInteger() {
            return integer;
        }

        public void setInteger(Integer integer) {
            this.integer = integer;
        }

        public Long getaLong() {
            return aLong;
        }

        public void setaLong(Long aLong) {
            this.aLong = aLong;
        }
    }
}
