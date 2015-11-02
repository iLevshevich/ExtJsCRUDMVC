package domain.controllers;

import domain.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import domain.service.UserService;

import java.util.*;

/**
 * Created by levshevich_i on 21.10.15.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String index() {
        return "users";
    }

    @RequestMapping(value = "/users/view.action", method = RequestMethod.GET)
     public @ResponseBody Map<String,? extends Object> getUser(@RequestParam int start, @RequestParam int limit) {
        try{
            List<User> users = userService.get(start, limit);
            int total = userService.getTotalUsers();
            return success(users, total);

        } catch (Exception e) {
            return failed("Error retrieving users from database.");
        }
    }

    @RequestMapping(value = "/users/view.action/{id}", method = RequestMethod.GET)
    public @ResponseBody Map<String,? extends Object> getUser(@PathVariable("id") String id) {
        try{
            List<User> users = new ArrayList<User>();
            {
                User user_ = userService.get(id);
                users.add(user_);
            }
            return success(users);

        } catch (Exception e) {
            return failed("Error retrieving users from database.");
        }
    }

    @RequestMapping(value = "/users/add.action", method = RequestMethod.PUT)
    public @ResponseBody Map<String,? extends Object> addUser(@RequestBody Map<String, Object> data) {
        try{
            {
                data.replace("id",null);
                data.replace("created", null);
                data.replace("modified", null);
            }
            User user = User.getUser(data);
            userService.add(user);

            List<User> users = new ArrayList<User>();
            users.add(user);
            return success(users);

        } catch (Exception e) {
            return failed("Error adding users from database.");
        }
    }
    @RequestMapping(value = "/users/update.action", method = RequestMethod.POST)
    public @ResponseBody Map<String,? extends Object> editUser(@RequestBody Map<String, Object> data) {
        try{
            {
                data.replace("modified", null);
            }
            User user = User.getUser(data);
            userService.update(user);

            List<User> users = new ArrayList<User>();
            {
                users.add(user);
            }
            return success(users);

        } catch (Exception e) {
            return failed("Error updating users from database.");
        }
    }

    @RequestMapping(value = "/users/remove.action", method = RequestMethod.DELETE)
    public @ResponseBody Map<String,? extends Object> deleteUser(@RequestBody Map<String, Object> data) {

        try{
            userService.remove((String) data.get("id"));

            List<User> users = new ArrayList<User>();
            return success(users);

        } catch (Exception e) {
            return failed("Error removing users from database.");
        }
    }

    private Map<String,Object> success(List<User> users){

        Map<String,Object> modelMap = new HashMap<String,Object>(3);
        modelMap.put("total", users.size());
        modelMap.put("data", users);
        modelMap.put("success", true);

        return modelMap;
    }

    private Map<String,Object> success(List<User> users, int total){

        Map<String,Object> modelMap = new HashMap<String,Object>(3);
        modelMap.put("total", total);
        modelMap.put("data", users);
        modelMap.put("success", true);

        return modelMap;
    }

    private Map<String,Object> failed(String msg){

        Map<String,Object> modelMap = new HashMap<String,Object>(2);
        modelMap.put("message", msg);
        modelMap.put("success", false);

        return modelMap;
    }

}
