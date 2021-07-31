package com.semih.api;

import com.semih.business.abstracts.JobPositionService;
import com.semih.business.concretes.JobManager;
import com.semih.core.utilities.results.Result;
import com.semih.model.dto.JobPositionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/job")
public class JobPositionController {
    private final JobPositionService jobPositionService;

    @PostMapping
    public Result saveJob(@RequestBody @Valid JobPositionDto registerRequest){
        return jobPositionService.saveJob(registerRequest);
    }
    @GetMapping
    public List<JobPositionDto> getAll(){
        return jobPositionService.getAll();
    }
}
