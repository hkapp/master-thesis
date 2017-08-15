create function countprimes(a NUMBER) return NUMBER is
  bound simple_integer := a;
  n simple_integer := 2;
  k simple_integer := 2;
  z simple_integer := 0;
  cnt simple_integer := 0;
  prime simple_integer := 1;
begin
  while (n <= bound) loop
    k := 2;
    prime := 1;
    while (k < n) loop
      z := n;
      while (z > 0) loop
        z := z - k;
      end loop;

      if (z = 0) then
        prime := 0;
        exit;
      end if;
      k := k + 1;
    end loop;
    cnt := cnt + prime;
    n := n + 1;
  end loop;

  return cnt;
end;
/
