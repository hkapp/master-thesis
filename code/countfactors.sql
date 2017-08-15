create function countfactors(a NUMBER) return NUMBER is
  n simple_integer := a;
  res simple_integer := 0;
  k simple_integer := 2;
  z simple_integer := 0;
  l simple_integer := 0;
  primefactor simple_integer := 0;
begin
while (n > 0) loop
  k := 2;
  while k < n loop
    z := n;
    while z > 0 loop
      z := z - k;
    end loop;

    if (z = 0) then
      l := 2;
      primefactor := 1;
      while (l < k) loop
        z := k;
        while (z > 0) loop
          z := z - l;
	end loop;

	if z = 0 then
	  primefactor := 0;
	  exit;
	end if;
        
	l := l + 1;
      end loop;
      
      res := res + primefactor * k;
    end if;

    k := k + 1;
  end loop;
n := n - 1;
end loop;

  return res;
end;
/
