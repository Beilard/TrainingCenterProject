package com.study.epamproject.domain.users;

public class Admin extends Client {
    private final Address supervisorName;

    protected Admin(AdminBuilder adminBuilder) {
        super(adminBuilder);
        this.supervisorName = adminBuilder.supervisorName;
    }

    public Address getSupervisorName() {
        return supervisorName;
    }

    public static class AdminBuilder extends ClientBuilder<AdminBuilder> {
        private Address supervisorName;

        public AdminBuilder() {
        }

        @Override
        public AdminBuilder self() {
            return this;
        }

        public Admin build() {
            return new Admin(self());
        }

        public AdminBuilder withSupervisorName(Address supervisorName) {
            this.supervisorName = supervisorName;
            return this;
        }
    }
}
