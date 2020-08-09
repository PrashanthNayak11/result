package mykiddrawing.quiz.Controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mykiddrawing.quiz.exception.ResourceNotFoundException;
import mykiddrawing.quiz.model.Result;
import mykiddrawing.quiz.repository.ResultRepository;
import mykiddrawing.quiz.repository.UserRepository;

@RestController
public class ResultController {

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private  UserRepository userRepository;

    @GetMapping("/users/{user_id}/results")
    public List < Result > getResultsByUser(@PathVariable(value = "user_id") Long user_id) {
        return resultRepository.findByUserId(user_id);
    }

    @PostMapping("/users/{user_id}/results")
    public Result createResult(@PathVariable(value = "user_id") Long user_id,
        @Valid @RequestBody Result result) throws ResourceNotFoundException {
        return userRepository.findById(user_id).map(user-> {
            result.setUser(user);
            return resultRepository.save(result);
        }).orElseThrow(()-> new ResourceNotFoundException("user not found"));
    }

    @PutMapping("/users/{user_id}/results/{Result_id}")
    public Result updateResult(@PathVariable(value = "user_id") Long user_id,
        @PathVariable(value = "Result_id") Long Result_id, @Valid @RequestBody Result resultRequest)
    throws ResourceNotFoundException {
        if (!userRepository.existsById(user_id)) {
            throw new ResourceNotFoundException("user_id not found");
        }

        return resultRepository.findById(Result_id).map(result-> {
            result.setTopic(resultRequest.getTopic());
            return resultRepository.save(result);
        }).orElseThrow(()-> new ResourceNotFoundException("result id not found"));
    }
   
    
}