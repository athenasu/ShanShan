package tw.idv.tibame.tfa104.shanshan.web.shop.entity;

public class Page{

		private int curPage; // 當前頁數
		private int totalRecord; // 總共資料條數
		private int pageStandard; // 每頁顯示條數
		
		// 計算總頁數
		public int getTotalPage() {
			int totalPage =  totalRecord / pageStandard ;
			
			return totalRecord % pageStandard == 0 ? totalPage : totalPage + 1 ;
		}

		public Page() {
			super();
		}

		public Page(int curPage, int totalRecord, int pageStandard) {
			super();
			this.curPage = curPage;
			this.totalRecord = totalRecord;
			this.pageStandard = pageStandard;
		}

		public int getCurPage() {
			return curPage;
		}

		public void setCurPage(int curPage) {
			this.curPage = curPage;
		}

		public int getTotalRecord() {
			return totalRecord;
		}

		public void setTotalRecord(int totalRecord) {
			this.totalRecord = totalRecord;
		}

		public int getPageStandard() {
			return pageStandard;
		}

		public void setPageStandard(int pageStandard) {
			this.pageStandard = pageStandard;
		}

		@Override
		public String toString() {
			return "Page [curPage=" + curPage + ", totalRecord=" + totalRecord + ", pageStandard=" + pageStandard + "]";
		}
		
		
}
