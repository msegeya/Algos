class StaticInnerClassEx {
	public static void main(String[] args) {
		// You can access the static variable directly without creating an object.
		System.out.println(OuterClass_static.InnerClass_static.x);

		// but to access other 
		OuterClass_static.InnerClass_static obj = new OuterClass_static.InnerClass_static();
		System.out.println(obj.y);
	}
}


class OuterClass_static {
	static class InnerClass_static {
		static int x = 10;
		public int y = 20;

		// Private variable so cannot be accessed from outside. Not even the OuterClass_static can access it.
		private void setY() {
			this.y = y;
		}
	}
}