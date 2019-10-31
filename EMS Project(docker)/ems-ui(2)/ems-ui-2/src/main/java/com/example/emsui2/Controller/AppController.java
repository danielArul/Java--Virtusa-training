package com.example.emsui2.Controller;


import com.example.emsui2.config.GetToken;
import com.example.emsui2.model.EPTdto;
import com.example.emsui2.model.Employee;
import com.example.emsui2.model.Project;
import com.example.emsui2.model.Task;
import com.example.emsui2.service.UIservice;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSPublicKeyParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;


import java.lang.reflect.Array;
import java.util.*;


@Controller
@EnableOAuth2Sso
public class AppController extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**", "/","/img/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/")
                .deleteCookies("KSESSION","JSESSIONID").invalidateHttpSession(true)
                .clearAuthentication(true);
    }

    @Autowired
    UIservice uIservice;

    @RequestMapping("/employees")
    public String employee(Model model){
        System.out.println(uIservice.allEmployees());
        model.addAttribute("Employees",uIservice.allEmployees());
        model.addAttribute("username",AccessTokenConfig.getPrincipalName());
        model.addAttribute("privilege",AccessTokenConfig.getAuthorities());
        return "employees";
    }

    @RequestMapping("/projects")
    public String project(Model model){
        System.out.println(uIservice.allProjects());
        model.addAttribute("Projects",uIservice.allProjects());
        model.addAttribute("username",AccessTokenConfig.getPrincipalName());
        model.addAttribute("privilege",AccessTokenConfig.getAuthorities());
        return "projects";
    }



    @RequestMapping("/tasks")
    public String task(Model model){
        System.out.println(uIservice.allTasks());
        model.addAttribute("Tasks",uIservice.allTasks());
        model.addAttribute("username",AccessTokenConfig.getPrincipalName());
        model.addAttribute("privilege",AccessTokenConfig.getAuthorities());
        return "tasks";
    }

    @RequestMapping(value = "/home")
    public  String loadHome(Model model){

        model.addAttribute("username",AccessTokenConfig.getPrincipalName());
        model.addAttribute("privilege",AccessTokenConfig.getAuthorities());
        return "home";
    }


    @RequestMapping(value = "/")
    public  String loadIndex(){
      return "index";
  }

    @RequestMapping(value="/ems/employee" ,method = RequestMethod.POST)
    public String createEmployee(@ModelAttribute Employee employee){
        uIservice.addEmployee(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value="/ems/project" ,method = RequestMethod.POST)
    public String createProject(@ModelAttribute Project project){
        uIservice.addProject(project);
        return "redirect:/projects";
    }

    @RequestMapping(value="/ems/task" ,method = RequestMethod.POST)
    public String createTask(@ModelAttribute Task task){
        System.out.println("test"+task);
        uIservice.addTask(task);
        return "redirect:/tasks";
    }

    @RequestMapping("/operations")
    public String operations(Model model){

        List<Employee> employees =new ArrayList<>();
        for(Employee e: uIservice.allEmployees()){
            employees.add(e);
        }
        List<Project> projects =new ArrayList<>();
        for(Project e: uIservice.allProjects()){
            projects.add(e);
        }
        List<Task> tasks =new ArrayList<>();
        for(Task e: uIservice.allTasks()){
            tasks.add(e);
        }

        model.addAttribute("username",AccessTokenConfig.getPrincipalName());
        model.addAttribute("privilege",AccessTokenConfig.getAuthorities());

        model.addAttribute("employees",employees);
        model.addAttribute("projects",projects);
        model.addAttribute("tasks", tasks);
        return "operations";


    }

    @RequestMapping(value="/ems/operations", method = RequestMethod.POST)
    public String operations(@ModelAttribute EPTdto eptdto){
        System.out.println(eptdto);
        uIservice.addOperation(eptdto);


        return "redirect:/operations";

    }

@RequestMapping("/employee/project/view/{eid}")
    public String getEmployeeProject(@PathVariable Integer eid ,Model model){
        model.addAttribute("projects",uIservice.getEmpProjects(eid));
        model.addAttribute("eid",eid);
    System.out.println(uIservice.getEmpProjects(eid));
        return "proInfo";
}

    @RequestMapping("/employee/project/view/task/{eid}/{pid}")
  public String getEmployeeProTasks(@PathVariable Integer eid,@PathVariable Integer pid,Model model){
        HttpHeaders header=new HttpHeaders();
        header.add("Authorization","bearer "+ GetToken.getToken());
        HttpEntity<String> req1=new HttpEntity<>(header);
        RestTemplate restTemplate=new RestTemplate();

        ResponseEntity<List<Integer>> response=restTemplate.exchange("http://demployee:8089/ems/employee/project/tasks/" + eid + "/" + pid, HttpMethod.GET, req1, new ParameterizedTypeReference<List<Integer>>() {
        });
        List<Integer> tids=response.getBody();

        System.out.println(tids);
        HttpEntity<List<Integer>> req2=new HttpEntity<>(tids,header);
        ResponseEntity<List<Task>> response1=restTemplate.exchange("http://dtask:8083/ems/project/tasks", HttpMethod.POST, req2, new ParameterizedTypeReference<List<Task>>() {
        });
      List<Task> tasks= new ArrayList<>();
      tasks=response1.getBody();
        System.out.println(tasks);
        model.addAttribute("tasks",tasks);


        return "taskinfo";
            }


//
//    @Autowired
//    RestTemplate restTemplate;
//
//    @Bean
//    RestTemplate restTemplate(){
//        return new RestTemplate();
//    }
//
//
//
//
//    @RequestMapping(value = "/home")
//    public  String loadHome(){
//        return "home";
//    }
//    @RequestMapping("/abc")
//    public String getPage(){
//        return "index";
//    }
////    @RequestMapping(value = "/home")
////    public  String loadreport(){
////        return "";
////    }
//
//
//
//    //display all employees
//    @RequestMapping(value = "/employees")
//    public String loadEmployees(Model model){
//
//        //Need to call profile service here
//
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Authorization",AccessTokenConfig.getToken());
//
//        HttpEntity<Employee> employeeHttpEntity = new HttpEntity<>(httpHeaders);
//        try{
//            ResponseEntity<Employee[]> responseEntity = restTemplate.exchange("http://localhost:8080/ems/employees",
//                    HttpMethod.GET,employeeHttpEntity,Employee[].class);
//
//            model.addAttribute("employees",responseEntity.getBody());
//        }
//        catch (HttpStatusCodeException se){
//
//            ResponseEntity responseEntity = ResponseEntity.status(se.getStatusCode())
//                    .headers(se.getResponseHeaders())
//                    .body(se.getResponseBodyAsString());
//            model.addAttribute("error",responseEntity);
//        }
//
//        return "employee";
//    }
//
//
//    //display specific employee details
//    @RequestMapping(value = "/employee/{id}")
//    public String loadEmployee(@PathVariable Integer id, Model model){
//
//        //Need to call profile service here
//        Set<Integer> filteredpid = new HashSet<>();
//        Set<Integer> filteredtid = new HashSet<>();
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Authorization",AccessTokenConfig.getToken());
//        HttpEntity<Employee> employeeHttpEntity = new HttpEntity<>(httpHeaders);
//        HttpEntity<Project> employeeHttpEntityP = new HttpEntity<>(httpHeaders);
//        HttpEntity<Task> employeeHttpEntityT = new HttpEntity<>(httpHeaders);
//        HttpEntity<Employee> employeeHttpEntityEs = new HttpEntity<>(httpHeaders);
//        HttpEntity<Operation> employeeHttpEntityO = new HttpEntity<>(httpHeaders);
//        try{
//            ResponseEntity<Employee[]> responseEntity = restTemplate.exchange("http://localhost:8980/ems/employees",
//                    HttpMethod.GET,employeeHttpEntity,Employee[].class);
//            ResponseEntity<Project[]> responseEntityP = restTemplate.exchange("http://localhost:8980/proj/projects",
//                    HttpMethod.GET,employeeHttpEntityP,Project[].class);
//
//            ResponseEntity<Task[]> responseEntityT = restTemplate.exchange("http://localhost:8980/task/tasks/",
//                    HttpMethod.GET,employeeHttpEntityT,Task[].class);
//            ResponseEntity<Employee> responseEntityEs = restTemplate.exchange("http://localhost:8980/ems/employee/"+id,
//                    HttpMethod.GET,employeeHttpEntityEs,Employee.class);
//            ResponseEntity<Operation[]> responseEntityO = restTemplate.exchange("http://localhost:8980/op/operations/"+id,
//                    HttpMethod.GET,employeeHttpEntityO,Operation[].class);
//
//
//            for(Operation op:responseEntityO.getBody()){
//
//                filteredpid.add(op.getPid());
//                filteredtid.add(op.getTid());
//            }
//
//            model.addAttribute("employees",responseEntity.getBody());
//            model.addAttribute("projects",responseEntityP.getBody());
//            model.addAttribute("tasks",responseEntityT.getBody());
//            model.addAttribute("employee",responseEntityEs.getBody());
//            model.addAttribute("operations",responseEntityO.getBody());
//            model.addAttribute("filteredpid",filteredpid);
//            model.addAttribute("filteredtid",filteredtid);
//        }
//        catch (HttpStatusCodeException se){
//
//            ResponseEntity responseEntity = ResponseEntity.status(se.getStatusCode())
//                    .headers(se.getResponseHeaders())
//                    .body(se.getResponseBodyAsString());
//            model.addAttribute("error",responseEntity);
//        }
//
//        return "emp_details";
//    }
//
//    //project details
//    @RequestMapping(value = "/project/{id}")
//    public String loadProjectDetails(@PathVariable Integer id, Model model){
//
//
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Authorization",AccessTokenConfig.getToken());
//
//        HttpEntity<Project> employeeHttpEntityPs = new HttpEntity<>(httpHeaders);
//
//        try{
//            ResponseEntity<Project> responseEntityPs = restTemplate.exchange("http://localhost:8980/proj/projects/"+id,
//                    HttpMethod.GET,employeeHttpEntityPs,Project.class);
//
//            model.addAttribute("project",responseEntityPs.getBody());
//
//        }
//        catch (HttpStatusCodeException se){
//
//            ResponseEntity responseEntity = ResponseEntity.status(se.getStatusCode())
//                    .headers(se.getResponseHeaders())
//                    .body(se.getResponseBodyAsString());
//            model.addAttribute("error",responseEntity);
//        }
//
//        return "project_details";
//    }
//
//    //project details
//    @RequestMapping(value = "/tasks/{id}")
//    public String loadTaskDetails(@PathVariable Integer id, Model model){
//
//
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Authorization",AccessTokenConfig.getToken());
//
//        HttpEntity<Task> employeeHttpEntityT = new HttpEntity<>(httpHeaders);
//
//        try{
//            ResponseEntity<Task> responseEntityT = restTemplate.exchange("http://localhost:8980/task/task/"+id,
//                    HttpMethod.GET,employeeHttpEntityT,Task.class);
//
//            model.addAttribute("task",responseEntityT.getBody());
//
//        }
//        catch (HttpStatusCodeException se){
//
//            ResponseEntity responseEntity = ResponseEntity.status(se.getStatusCode())
//                    .headers(se.getResponseHeaders())
//                    .body(se.getResponseBodyAsString());
//            model.addAttribute("error",responseEntity);
//        }
//
//        return "task_details";
//    }
//
//    //display specific employee's particular task
//    @RequestMapping(value = "/employee/{id}/tasks")
//    public String loadProjectTask(@PathVariable int id, Model model){
//
//        //Need to call profile service here
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Authorization",AccessTokenConfig.getToken());
//
//        HttpEntity<Employee> employeeHttpEntity = new HttpEntity<>(httpHeaders);
//        try{
//            ResponseEntity<Employee> responseEntity = restTemplate.exchange("http://localhost:8980/ems/employee/"+id,
//                    HttpMethod.GET,employeeHttpEntity,Employee.class);
//            model.addAttribute("employee",responseEntity.getBody());
//        }
//        catch (HttpStatusCodeException se){
//            System.out.println("test");
//            ResponseEntity responseEntity = ResponseEntity.status(se.getStatusCode())
//                    .headers(se.getResponseHeaders())
//                    .body(se.getResponseBodyAsString());
//            model.addAttribute("error",responseEntity);
//        }
//
//        return "emp_task";
//    }
//
//    //display all project details
//    @RequestMapping(value = "/projects")
//    public String loadProject(Model model){
//
//        //Need to call profile service here
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Authorization",AccessTokenConfig.getToken());
//
//        HttpEntity<Project> employeeHttpEntity = new HttpEntity<>(httpHeaders);
//        try{
//            ResponseEntity<Project[]> responseEntity = restTemplate.exchange("http://localhost:8980/proj/projects/",
//                    HttpMethod.GET,employeeHttpEntity,Project[].class);
//            model.addAttribute("projects",responseEntity.getBody());
//        }
//        catch (HttpStatusCodeException se){
//            System.out.println("test");
//            ResponseEntity responseEntity = ResponseEntity.status(se.getStatusCode())
//                    .headers(se.getResponseHeaders())
//                    .body(se.getResponseBodyAsString());
//            model.addAttribute("error",responseEntity);
//        }
//
//        return "project";
//    }
//
//    //display all task details
//    @RequestMapping(value = "/tasks")
//    public String loadTask(Model model){
//
//        //Need to call profile service here
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Authorization",AccessTokenConfig.getToken());
//
//        HttpEntity<Task> employeeHttpEntity = new HttpEntity<>(httpHeaders);
//        try{
//            ResponseEntity<Task[]> responseEntity = restTemplate.exchange("http://localhost:8980/task/tasks/",
//                    HttpMethod.GET,employeeHttpEntity,Task[].class);
//            model.addAttribute("tasks",responseEntity.getBody());
//        }
//        catch (HttpStatusCodeException se){
//            System.out.println("test");
//            ResponseEntity responseEntity = ResponseEntity.status(se.getStatusCode())
//                    .headers(se.getResponseHeaders())
//                    .body(se.getResponseBodyAsString());
//            model.addAttribute("error",responseEntity);
//        }
//
//        return "task";
//    }
//
//    @RequestMapping(value = "/operations")
//    public String loadOperation(Model model){
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Authorization",AccessTokenConfig.getToken());
//
//        HttpEntity<Employee> employeeHttpEntity = new HttpEntity<>(httpHeaders);
//        HttpEntity<Project> employeeHttpEntityP = new HttpEntity<>(httpHeaders);
//        HttpEntity<Task> employeeHttpEntityT = new HttpEntity<>(httpHeaders);
//
//        try{
//            ResponseEntity<Employee[]> responseEntity = restTemplate.exchange("http://localhost:8980/empl/employees",
//                    HttpMethod.GET,employeeHttpEntity,Employee[].class);
//
//            ResponseEntity<Project[]> responseEntityP = restTemplate.exchange("http://localhost:8980/proj/projects",
//                    HttpMethod.GET,employeeHttpEntityP,Project[].class);
//
//            ResponseEntity<Task[]> responseEntityT = restTemplate.exchange("http://localhost:8980/tsk/tasks/",
//                    HttpMethod.GET,employeeHttpEntityT,Task[].class);
//
//            model.addAttribute("employees",responseEntity.getBody());
//            model.addAttribute("projects",responseEntityP.getBody());
//            model.addAttribute("tasks",responseEntityT.getBody());
//
//
//        }
//        catch (HttpStatusCodeException se){
//
//            ResponseEntity responseEntity = ResponseEntity.status(se.getStatusCode())
//                    .headers(se.getResponseHeaders())
//                    .body(se.getResponseBodyAsString());
//            model.addAttribute("error",responseEntity);
//        }
//
//        return "operation";
//    }
//
//    @RequestMapping(value = "/operation")
//    public String saveOperation(@ModelAttribute() Operation operation){
//
//        System.out.println(operation);
//        return "home";
//
//    }
//
//    @RequestMapping(value = "/menu")
//    public String loadReport(Model model){
//
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Authorization",AccessTokenConfig.getToken());
//
//        HttpEntity<Employee> employeeHttpEntity = new HttpEntity<>(httpHeaders);
//        HttpEntity<Project> employeeHttpEntityP = new HttpEntity<>(httpHeaders);
//        HttpEntity<Task> employeeHttpEntityT = new HttpEntity<>(httpHeaders);
//        try{
//            ResponseEntity<Employee[]> responseEntity = restTemplate.exchange("http://localhost:8980/empl/employees",
//                    HttpMethod.GET,employeeHttpEntity,Employee[].class);
//            ResponseEntity<Project[]> responseEntityP = restTemplate.exchange("http://localhost:8980/proj/projects",
//                    HttpMethod.GET,employeeHttpEntityP,Project[].class);
//
//            ResponseEntity<Task[]> responseEntityT = restTemplate.exchange("http://localhost:8980/tsk/tasks/",
//                    HttpMethod.GET,employeeHttpEntityT,Task[].class);
//
//            model.addAttribute("employees",responseEntity.getBody());
//            model.addAttribute("projects",responseEntityP.getBody());
//            model.addAttribute("tasks",responseEntityT.getBody());
//            model.addAttribute("opob", new Operation_Tasks());
//        }
//        catch (HttpStatusCodeException se){
//
//            ResponseEntity responseEntity = ResponseEntity.status(se.getStatusCode())
//                    .headers(se.getResponseHeaders())
//                    .body(se.getResponseBodyAsString());
//            model.addAttribute("error",responseEntity);
//        }
//        return "home";
//
//    }
//



}
