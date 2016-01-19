package minEditAlgorithms;

public class DTWStrings extends StringTransformer
	{

		private DTW dtw;
	
		public DTWStrings()
		{
			super();
		}
		public DTWStrings(int ins_cost, int del_cost, int subs_cost)
		{
			super(ins_cost, del_cost, subs_cost);
		}
		


	@Override
	public double minTransformCost(String source, String target, int ins_cost, int del_cost, int subs_cost)
		{
		
			dtw = new DTW(new DTWSpellCheckCostFunc(ins_cost, del_cost, subs_cost));
			
			totalCost = dtw.minTransformCost(new Segment(source), new Segment(target));
			
			costs = dtw.costs;
			
			return totalCost;
		}


		
	}
