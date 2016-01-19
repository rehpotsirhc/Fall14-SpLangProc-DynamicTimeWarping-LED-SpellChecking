package minEditAlgorithms;

public class DTWSpellCheckCostFunc extends DTWCostFunc
	{
		
		
		
		
		


		public DTWSpellCheckCostFunc(int insCost, int delCost, int subsCost)
		{
			super(insCost, delCost, subsCost);
			// TODO Auto-generated constructor stub
		}

		@Override
		public double cost(Segment source, Segment target, int posSource, int posTarget, EditType editType)
			{
				
				if(source.EqualAt(target, posSource, posTarget)) return 0;
				else 
					{
						if(editType != null)
							{
								if(editType == EditType.Ins) return getInsCost();
								if(editType == EditType.Del) return getDelCost();
								if(editType == EditType.Sub) return getSubsCost();
							}
						
						return 1;
					}
				
			}
	}
