// Lắng nghe sự kiện khi nội dung trong form thay đổi
const formInputs = document.querySelectorAll(".form-input input");
formInputs.forEach((input) => {
  input.addEventListener("input", updateItemContainer);
});

// Hàm xử lý sự kiện
function updateItemContainer() {
  // Lấy giá trị mới từ các input
  const link = document.querySelector('input[name="link"]').value;
  const description = document.querySelector('input[name="discription"]').value;
  const firstLoan = document.querySelector('input[name="firstLoan"]').value;
  const maxLoan = document.querySelector('input[name="maxLoan"]').value;
  const minAge = document.querySelector('input[name="minAge"]').value;
  const maxAge = document.querySelector('input[name="maxAge"]').value;

  const itemDescription = document.querySelector(".item-description p");
  itemDescription.innerText = description;

  const firstLoanElement = document.querySelector(".item-detail .firth");
  firstLoanElement.innerText = "Khoản vay đầu";

  const secondLoanElement = document.querySelector(".item-detail .second");
  secondLoanElement.innerHTML = `0% đến &nbsp;<span class="number first-loan">${firstLoan}</span>`;

  const maxLoanElement = document.querySelector(".item-detail .thirth");
  maxLoanElement.innerHTML = `Số tiền tối đa &nbsp;<span class="number max-loan">${maxLoan}</span>`;

  const minAgeElement = document.querySelector(".item-detail .number.min-age");
  minAgeElement.innerText = minAge;

  const maxAgeElement = document.querySelector(".item-detail .number.max-age");
  maxAgeElement.innerText = maxAge;
}

// Lắng nghe sự kiện khi thay đổi hình ảnh
const fileInput = document.querySelector('input[type="file"]');
fileInput.addEventListener("change", displaySelectedImage);

// Hàm xử lý sự kiện
function displaySelectedImage() {
  const file = fileInput.files[0];
  if (file) {
    const reader = new FileReader();

    reader.onload = function (e) {
      const selectedImage = e.target.result;
      const itemImg = document.querySelector(".item-img img");
      itemImg.src = selectedImage;
    };

    reader.readAsDataURL(file);
  }
}
