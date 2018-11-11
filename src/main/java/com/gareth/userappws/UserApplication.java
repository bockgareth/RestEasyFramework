package com.gareth.userappws;

import com.gareth.userappws.ui.controller.UserController;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class UserApplication extends Application {

    private Set<Object> singletons = new HashSet<>();

    public UserApplication() {
        singletons.add(new UserController());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}