package lk.ac.mrt.cse.mscresearch.remoting;

import java.util.List;

import lk.ac.mrt.cse.mscresearch.codeclones.Clone;
import lk.ac.mrt.cse.mscresearch.codeclones.CodeFragmentData;

public interface CloneFinder {

	List<Clone> find(List<CodeFragmentData> codeFragment);
}
