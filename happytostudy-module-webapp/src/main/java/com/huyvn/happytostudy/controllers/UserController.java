package com.huyvn.happytostudy.controllers;

import com.huyvn.happytostudy.authentication.TokenUtils;
import com.huyvn.happytostudy.model.UserModel;
import com.huyvn.happytostudy.services.UserService;
import com.huyvn.happytostudy.transfer.TokenTransfer;
import com.huyvn.happytostudy.transfer.UserTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Knightzoro on 12/27/15.
 */

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authManager;

    @RequestMapping(value = "getUserList", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    List<UserModel> getUsetList() {
        return userService.findAll();
    }

    /**
     * Retrieves the currently logged in user.
     *
     * @return A transfer containing the username and the roles.
     */
    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    UserTransfer getUser()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof String && ((String) principal).equals("anonymousUser")) {
            return null;
//            throw new WebApplicationException(401);
        }
        UserDetails userDetails = (UserDetails) principal;

        return new UserTransfer(userDetails.getUsername(), this.createRoleMap(userDetails));
    }

    /**
     * Authenticates a user and creates an authentication token.
     *
     * @param username
     *            The name of the user.
     * @param password
     *            The password of the user.
     * @return A transfer containing the authentication token.
     */
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST, headers = "Accept=application/json")
    public @ResponseBody
    TokenTransfer authenticate(@RequestParam("username") String username, @RequestParam("password") String password)
    {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = this.authManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

		/*
		 * Reload user as password of authentication principal will be null after authorization and
		 * password is needed for token generation
		 */
        UserDetails userDetails = this.userService.loadUserByUsername(username);

        return new TokenTransfer(TokenUtils.createToken(userDetails));
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST, headers = "Accept=application/json")
    public @ResponseBody
    TokenTransfer authenticate_2()
    {
        String username = "admin";
        String password = "admin";

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = this.authManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

		/*
		 * Reload user as password of authentication principal will be null after authorization and
		 * password is needed for token generation
		 */
        UserDetails userDetails = this.userService.loadUserByUsername(username);

        return new TokenTransfer(TokenUtils.createToken(userDetails));
    }

    private Map<String, Boolean> createRoleMap(UserDetails userDetails)
    {
        Map<String, Boolean> roles = new HashMap<String, Boolean>();
        for (GrantedAuthority authority : userDetails.getAuthorities()) {
            roles.put(authority.getAuthority(), Boolean.TRUE);
        }

        return roles;
    }
}
