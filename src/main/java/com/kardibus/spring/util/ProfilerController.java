package com.kardibus.spring.util;

import lombok.Data;

@Data
public class ProfilerController implements ProfilingControllerMXBean {
    private boolean enabled;
}
