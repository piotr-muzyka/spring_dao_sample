package com.pmuz.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.pmuz.model.User;

public class UserDao implements Dao<User> {

	private List<User> users = new ArrayList<>();

	public UserDao() {
		users.add(new User("John", "john@domain.com"));
		users.add(new User("Susan", "susan@domain.com"));
	}

	@Override
	public Optional get(long id) {
		return Optional.ofNullable(users.get((int) id));
	}

	@Override
	public List getAll() {
		return users;
	}

	@Override
	public void save(User user) {
		users.add(user);

	}

	@Override
	public void update(User user, String[] params) {
		user.setName(Objects.requireNonNull(params[0], "Name cannot be null"));
		user.setEmail(Objects.requireNonNull(params[1], "Email cannot be null"));

		users.add(user);

	}

	@Override
	public void delete(User user) {
        users.remove(user);

	}
}
