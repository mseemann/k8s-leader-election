package io.mseemann.poc.k8sleaderelection;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LeaderInfo {

  SingletonService singletonService;

  @GetMapping("/are-you-the-leader")
  public String areYouTheLeader() {
    return singletonService.isLeader() ? "I am the leader!" : "I am not the leader";
  }
}
