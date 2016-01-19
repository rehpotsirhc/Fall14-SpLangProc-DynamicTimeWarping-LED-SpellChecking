package minEditAlgorithms;

import java.util.*;


public abstract class Transformer
	{
		protected double[][]			costs;
		protected Map<Node, EditType>	path;
		protected double				totalCost;

		public abstract double minTransformCost(Segment s1, Segment s2);

		protected void recoverPath()
			{
				path = new HashMap<Node, EditType>();
				int r = costs.length - 1;
				int c = costs[0].length - 1;
				while (r >0 || c > 0)
					{
						double insert = Integer.MAX_VALUE;
						double del = Integer.MAX_VALUE;
						double subs = Integer.MAX_VALUE;
						
						
						if (r > 0 && c > 0) subs = costs[r - 1][c - 1];
						
						if (r > 0) del = costs[r - 1][c];
						
						if (c > 0) insert = costs[r][c - 1];
						
						
						
						double minimum = Math.min(Math.min(subs, del), insert);
						
						if (subs == minimum)
							{
								
								 path.put(new Node(r - 1, c - 1), EditType.Sub);
								r = r - 1;
								c = c - 1;
							} else if (del == minimum)
							{
								
								 path.put(new Node(r - 1, c - 1), EditType.Del);
								r = r - 1;
							} else
							{
								
								path.put(new Node(r - 1, c - 1), EditType.Ins);
								c = c - 1;
							}
					}
			}

		protected abstract void recoverTransformSteps(Segment s1, Segment s2);

		public double Transform(Segment s1, Segment s2)
			{
				minTransformCost(s1, s2);
				recoverTransformSteps(s1, s2);
				
				return totalCost;
			}
	}
