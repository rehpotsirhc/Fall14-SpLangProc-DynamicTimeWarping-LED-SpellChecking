package minEditAlgorithms;

public abstract class DTWCostFunc
	{
		
		private int  insCost;
		private int  delCost;
		private int  subsCost;
		private EditType  editType;
		
		public DTWCostFunc(int insCost, int delCost, int subsCost)
		{
			this.insCost = insCost;
			this.delCost = delCost;
			this.subsCost = subsCost;
			
		}
		
		
		
		public abstract double cost(Segment source, Segment target, int posSource, int posTarget, EditType editType);


		protected int getInsCost()
			{
				return insCost;
			}


		protected int getDelCost()
			{
				return delCost;
			}


		protected int getSubsCost()
			{
				return subsCost;
			}

		protected EditType getEditType()
			{
				return editType;
			}
		
		
		
		
	}
