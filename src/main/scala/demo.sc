

def f(int: Int): String = int.toString

def doIt(f: Int => String, int: Int) = f(int)

println(doIt(f, 10))
