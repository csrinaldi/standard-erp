package com.logikas.kratos.system.client.widget;

import com.logikas.kratos.system.client.view.SearchUserView;
import com.logikas.kratos.system.shared.proxy.UserProxy;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.Range;

import java.util.List;

public class SearchUserWidget extends Composite implements SearchUserView {

  static interface SearchUserBinder extends UiBinder<HTMLPanel, SearchUserWidget> {
  }

  private static final SearchUserBinder BINDER = GWT.create(SearchUserBinder.class);

  private Presenter presenter;

  private final AsyncDataProvider<UserProxy> dataProvider = new AsyncDataProvider<UserProxy>() {
    @Override
    protected void onRangeChanged(HasData<UserProxy> display) {
      final Range range = display.getVisibleRange();
      if (presenter != null) {
        // presenter.searchUsers(name.getValue(), range.getStart(), range.getLength());
        presenter.findAll(range.getStart(), range.getLength());
      }
    }
  };

  @UiField(provided = true)
  final SimplePager pager;

  @UiField(provided = true)
  final CellTable<UserProxy> userTable;

  public SearchUserWidget() {

    userTable = new CellTable<UserProxy>();

    final TextColumn<UserProxy> nameColumn = new TextColumn<UserProxy>() {
      @Override
      public String getValue(UserProxy user) {
        return user.getName();
      }
    };

    userTable.addColumn(nameColumn);

    dataProvider.addDataDisplay(userTable);

    // Set the range to display. In this case, our visible range is smaller than
    // the data set.
    userTable.setVisibleRange(0, 3);

    // Create a SimplePager.
    pager = new SimplePager();

    // Set the cellList as the display.
    pager.setDisplay(userTable);

    initWidget(BINDER.createAndBindUi(this));
  }

  @Override
  public void setPresenter(Presenter presenter) {
    this.presenter = presenter;
  }

  @UiField
  TextBox name;

  @UiHandler("search")
  void search(ClickEvent event) {
    pager.firstPage();
  }

  @Override
  public void setUsers(int start, List<UserProxy> users) {
    dataProvider.updateRowData(start, users);
  }
}
