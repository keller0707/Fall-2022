program gaussian
  implicit none
  
  integer N, i, j, k
  real ratio
  real, dimension(:,:), allocatable :: A
  real, dimension(:), allocatable :: x
  character(100) :: input

  ! Read in Command Arg
  call GET_COMMAND_ARGUMENT(1, input)
  read(input,*)N

  !Allocate Space
  ALLOCATE(A(N ,N+1))
  ALLOCATE(x(N))

  !Randomizes Number
  call random_number(A)
  do i = 1, N
    do j = 1, N+1
      A(i,j) = 1 + FLOOR(10*A(i,j))
    end do
  end do

  
  !Gaussian Elimination
  do i = 1, N
    if ( A(i,i) == 0 ) then
      A(i,i) = 1
    end if

    do j = i+1, N
      ratio = A(j,i)/A(i,i)
      
      do k = 1, N+1
        A(j,k) = A(j, k) - ratio * A(i,k)
      end do
    end do
  end do
  
  !Backward Sub.
  x(N) = A(N,N+1)/A(N,N)
  do i = N-1, 1, -1
    x(i) = A(i,N)
    do j = i+1, N
      x(i) = x(i) - A(i,j)*x(j)
    end do
    x(i) = x(i)/A(i,i)
  end do
  
end program gaussian
