package com.ikkat.los.Process;

import com.ikkat.los.shared.ProcessReturn;
import org.springframework.stereotype.Service;

@Service
public class ProcessHandler implements ProcessService{
    @Override
    public ProcessReturn ProcessingFunction(String codepermission, Object data, String authorization) {
        return null;
    }

    @Override
    public ProcessReturn ProcessingReadFunction(String codepermission, Object data, String authorization) {
        return null;
    }
}
