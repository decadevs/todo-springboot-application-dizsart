package com.assignment.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
public class AppController {
    @Autowired
    private TodoService ts;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Todo> listTodo = ts.listAll();
        model.addAttribute("listTodo", listTodo);
        return "index";
    }
    @RequestMapping("/add")
    public String addTodo(Model model) {
        Todo todo = new Todo();
        model.addAttribute("todo", todo);
        return "addTodo";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveTodo(@ModelAttribute("todo") Todo todo){
        if(todo.getStatus().equalsIgnoreCase("Completed")) {
            todo.setCompletedAt(new Timestamp(new Date().getTime()));
            ts.save(todo);
        }
        else {
            ts.save(todo);
        }
         return "redirect:/";
    }

    @RequestMapping("/editTodo/{id}")
    public ModelAndView editTodo(@PathVariable(name = "id")Long id) {
        ModelAndView instanceOfModelAndView = new ModelAndView("editTodo");
        Todo todo = ts.get(id);
        instanceOfModelAndView.addObject("todo", todo);
        return instanceOfModelAndView;
    }
    @RequestMapping("/view/{id}")
    public ModelAndView viewTodo(@PathVariable(name = "id")Long id) {
        ModelAndView instanceOfModelAndView = new ModelAndView("view");
        Todo todo = ts.get(id);
        instanceOfModelAndView.addObject("todo", todo);
        return instanceOfModelAndView;
    }

    @RequestMapping("/progress")
    public String viewTasksInProgress(Model model) {
        List<Todo> listTodo = ts.listAllInProgressTasks();
        model.addAttribute("listTodo", listTodo);
        return "index";
    }

    @RequestMapping("/pending")
    public String viewTasksPending(Model model) {
        List<Todo> listTodo = ts.listAllPendingTasks();
        model.addAttribute("listTodo", listTodo);
        return "index";
    }
    @RequestMapping("/completed")
    public String viewTasksCompleted(Model model) {
        List<Todo> listTodo = ts.listAllCompletedTasks();
        model.addAttribute("listTodo", listTodo);
        return "index";
    }




    @RequestMapping("/delete/{id}")
    public String deleteTodo(@PathVariable(name = "id") Long id) {
        ts.delete(id);
        return "redirect:/";
    }

}
