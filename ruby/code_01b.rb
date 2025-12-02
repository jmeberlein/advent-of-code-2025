file = IO.foreach(ARGV[0]).map(&:strip)[1..]

prev = 50
curr = 50
res = 0

file.each do |line|
  adj = line[1..].to_i
  res += adj / 100
  adj %= 100

  if line[0] == 'R'
    curr = prev + adj
  else
    curr = prev - adj
  end

  res += 1 if curr > 100 || (curr < 0 && prev != 0)
  prev = curr % 100
  res += 1 if prev.zero?
end

puts res