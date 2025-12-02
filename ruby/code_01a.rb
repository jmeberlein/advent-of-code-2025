file = IO.foreach(ARGV[0]).map(&:strip)

ptr = 50
res = 0
file.each do |line|
  if line[0] == 'R'
    ptr += line[1..].to_i
  else
    ptr -= line[1..].to_i
  end
  ptr %= 100

  res += 1 if ptr.zero?
end

puts res