package minEditAlgorithms;



public class LED extends StringTransformer
	{
		public LED()
		{
			super();
		}
		
		public LED(int ins_cost, int del_cost, int subs_cost)
		{
			super(ins_cost, del_cost, subs_cost);
		}
		
		@Override
		public double minTransformCost(String source, String target, int ins_cost, int del_cost, int subs_cost)
			{
				
				costs = new double[source.length() + 1][target.length() + 1];
				if (source.length() == 0)
					{
						if (target.length() == 0)
							return 0;
						else
							return target.length() * ins_cost;
					} else
					{
						if (target.length() == 0)
							return source.length() * del_cost;
						// both target and source contain at least 1 character
						// each
						else
							{
								double newWithSub = 0;
								double newWithDel = 0;
								double newWithIns = 0;
								double minimum = 0;
								for (int r = 0; r < costs.length; r++)
									{
										for (int c = 0; c < costs[0].length; c++)
											{
												if (r == 0)
													{
														costs[0][c] = c * ins_cost;
														continue;
													} else if (c == 0)
													{
														costs[r][0] = r * del_cost;
														continue;
													}
												// r -1 and c - 1 because the
												// column and row indices are
												// each 1 place ahead of the
												// index in the two strings
												// this is because the algorithm
												// uses an empty string as the
												// beginning character of each
												// word, but that's not really
												// in the string
												if (source.charAt(r - 1) == target.charAt(c - 1))
													{
														costs[r][c] = costs[r - 1][c - 1];
													} else
													{
														newWithSub = costs[r - 1][c - 1] + subs_cost;
														newWithDel = costs[r - 1][c] + del_cost;
														newWithIns = costs[r][c - 1] + ins_cost;
														minimum = Math.min(Math.min(newWithSub, newWithDel), newWithIns);
														if (minimum == newWithSub)
															{
																costs[r][c] = newWithSub;
															} else if (minimum == newWithDel)
															{
																costs[r][c] = newWithDel;
															} else if (minimum == newWithIns)
															{
																costs[r][c] = newWithIns;
															}
													}
											}
									}
								totalCost = costs[source.length()][target.length()];
								return totalCost;
							}
					}
			}
	}
