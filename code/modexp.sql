create function modexp(a NUMBER, b NUMBER, c NUMBER) return NUMBER is
  base simple_integer := a;
  exp simple_integer := b;
  modulo simple_integer := c;
  res simple_integer := 1;
begin
  if (exp < 0 OR modulo <= 0) then
    return -1;
  elsif (exp = 0) then
    return 1;
  elsif (exp > 100) then
    exp := 100;
  end if;
 
  if (base = 0 OR modulo = 1) then
    return 0;
  end if;
 
  while (exp > 0 AND res != 0) loop
    res := res * base;
    
    while (res <= -modulo) loop
      res := res + modulo;
    end loop;

    while (res >= modulo) loop
      res := res - modulo;
    end loop;

    exp := exp - 1;
  end loop;
 
  return res;
end;
/
