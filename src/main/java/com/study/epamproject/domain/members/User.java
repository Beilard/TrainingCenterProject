package com.study.epamproject.domain.members;

public class User {
    private final Long id;
    private final String name;
    private final String surname;
    private final String email;
    private final String password;

    protected User(UserBuilder<? extends UserBuilder> userBuilder) {
        this.id = userBuilder.id;
        this.name = userBuilder.name;
        this.surname = userBuilder.surname;
        this.email = userBuilder.email;
        this.password = userBuilder.password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static class UserBuilder<B extends UserBuilder<B>> {
        private Long id;
        private String name;
        private String surname;
        private String email;
        private String password;

        protected UserBuilder(){}

        @SuppressWarnings("unchecked")
        public B self() {
            return (B) this;
        }

        public User build() {
            return new User(self());
        }

        public UserBuilder<B> withId(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder<B> withName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder<B> withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public UserBuilder<B> withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder<B> withPassword(String password) {
            this.password = password;
            return this;
        }
    }
}
