package io.mseemann.poc.k8sleaderelection;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.integration.leader.event.OnGrantedEvent;
import org.springframework.integration.leader.event.OnRevokedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SingletonService {

    private boolean leader;

    @EventListener
    public void onLeadershipGained(OnGrantedEvent event) {
        log.info("onLeadershipGained {}", event);
        leader = true;
    }

    @EventListener
    public void onLeadershipLost(OnRevokedEvent event) {
        log.info("onLeadershipLost {}", event);
        leader = false;
    }

    public boolean isLeader() {
        return leader;
    }

}
