package minEditAlgorithms;

import java.util.Iterator;
import java.util.LinkedList;


public abstract class StringTransformer extends Transformer
	{
		protected LinkedList<Edit>	edits;
		private int					insCost;
		private int					delCost;
		private int					subsCost;


		public StringTransformer()
			{
		
				insCost = delCost = subsCost = 1;
			}

		public StringTransformer(int ins_cost, int del_cost, int subs_cost)
			{
				insCost = ins_cost;
				delCost = del_cost;
				subsCost = subs_cost;
			}

		protected void recoverTransformSteps(Segment s1, Segment s2)
			{
				recoverPath();
				edits = new LinkedList<Edit>();
				for (Node n : path.keySet())
					{
						if (path.get(n) == EditType.Sub)
							{
								if (!s1.EqualAt(s2, n.getI(), n.getJ())) edits.add(Edit.CreateSubs(n.getI(), s1.getCharacters()[n.getI()], n.getJ(), s2.getCharacters()[n.getJ()], subsCost));
							} else if (path.get(n) == EditType.Del)
							{
								edits.add(Edit.CreateDel(n.getI(), s1.getCharacters()[n.getI()], delCost));
							} else
							{
								edits.add(Edit.CreateIns(n.getI(), s2.getCharacters()[n.getJ()], insCost));
							}
					}
			}

		public double minTransformCost(Segment source, Segment target)
			{
				return minTransformCost(source.getString(), target.getString());
			}

		public double minTransformCost(String source, String target)
			{
				return minTransformCost(source, target, insCost, delCost, subsCost);
			}

		public abstract double minTransformCost(String source, String target, int ins_cost, int del_cost, int subs_cost);

		protected void recoverTransformSteps(String source, String target)
			{
				recoverTransformSteps(new Segment(source), new Segment(target));
			}

		protected void recoverTransformSteps(String source, String target, int ins_cost, int del_cost, int subs_cost)
			{
				insCost = ins_cost;
				delCost = del_cost;
				subsCost = subs_cost;
				recoverTransformSteps(new Segment(source), new Segment(target));
			}

		public double Transform(String source, String target)
			{
				return Transform(new Segment(source), new Segment(target));
			}

		public double Transform(String source, String target, int ins_cost, int del_cost, int subs_cost)
			{
				insCost = ins_cost;
				delCost = del_cost;
				subsCost = subs_cost;
				return Transform(new Segment(source), new Segment(target));
			}

	
		public String toString()
			{
				String s = "COST: " + totalCost + "\n";
				s += "EDITS:\n";
				Iterator<Edit> iter = edits.descendingIterator();
				while (iter.hasNext())
					{
						s += iter.next().toString() + "\n";
					}
				return s;
			}
		
		
	}
