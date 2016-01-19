package minEditAlgorithms;


public class DTW extends Transformer
	{
		private DTWCostFunc	costFunc;

		public DTW(DTWCostFunc costFuct)
			{
				this.costFunc = costFuct;
			
			}

		@Override
		public double minTransformCost(Segment s1, Segment s2)
			{
				costs = new double[s1.getLength()][s2.getLength()];
				for (int r = 0; r < costs.length; r++)
					{
						for (int c = 0; c < costs[0].length; c++)
							{
								
								if (r == 0)
									{
										if (c == 0)
											costs[0][0] = costFunc.cost(s1, s2, 0, 0, null);
										else
											costs[0][c] = costFunc.cost(s1, s2, 0, c, null) + costs[0][c - 1];
										continue;
									} else if (c == 0)
									{
										costs[r][0] = costFunc.cost(s1, s2, r, c, null) + costs[r - 1][0];
										continue;
									} else
									{
										double sub = costs[r - 1][c - 1];
										double del = costs[r - 1][c];
										double ins = costs[r][c - 1];
										double minimum = Math.min(Math.min(sub, del), ins);
										
										EditType editType = null;
										
										if(sub == minimum) editType = EditType.Sub;
										if(ins == minimum) editType = EditType.Ins;
										if(del == minimum) editType = EditType.Del;
										
										costs[r][c] = costFunc.cost(s1, s2, r, c, editType) + minimum;
									}
							}
					}
				totalCost = costs[s1.getLength() - 1][s2.getLength() - 1];
				return totalCost;
			}

		@Override
		protected void recoverTransformSteps(Segment s1, Segment s2)
			{
				recoverPath();
			}
	}
