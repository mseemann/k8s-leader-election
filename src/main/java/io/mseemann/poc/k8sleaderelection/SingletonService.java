package io.mseemann.poc.k8sleaderelection;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.integration.leader.event.OnGrantedEvent;
import org.springframework.integration.leader.event.OnRevokedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SingletonService {

  private boolean started;

  @EventListener
  public void onLeadershipGained(OnGrantedEvent event) {
    log.info("onLeadershipGained {}", event);
    this.start();
  }

  @EventListener
  public void  onLeadershipLost(OnRevokedEvent event) {
    log.info("onLeadershipLost {}", event);
    this.stop();
  }

  public void start() {
    log.info("SingletonService has been started on the leader pod");
    started = true;
  }

  public boolean isStarted() {
    return started;
  }

  public void stop() {
    log.info("SingletonService has been stopped on the leader pod");
    started = false;
  }


}
