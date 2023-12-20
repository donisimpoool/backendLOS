package com.ikkat.los.Process;


import com.ikkat.los.shared.ProcessReturn;

public interface ProcessService {
	ProcessReturn ProcessingFunction(String codepermission, Object data, String authorization);
	ProcessReturn ProcessingReadFunction(String codepermission,Object data,String authorization);
}
