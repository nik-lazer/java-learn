package lan.training.gwt.client.ui;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.ProvidesKey;
import lan.training.core.model.Publisher;
import lan.training.gwt.shared.dto.AbstractDto;
import lan.training.gwt.shared.dto.AuthorDto;
import lan.training.gwt.shared.dto.BookDto;
import lan.training.gwt.shared.dto.LanguageDto;
import lan.training.gwt.shared.dto.PublisherDto;

import java.util.List;

/**
 * Grid panel
 * @author nik-lazer  06.10.2015   12:19
 */
public class GridPanel extends SimplePanel {
	private CellTable table;


	public static final ProvidesKey<AbstractDto> KEY_PROVIDER = new ProvidesKey<AbstractDto>() {
		@Override
		public Object getKey(AbstractDto item) {
			return item == null ? null : item.getUid();
		}
	};

	public GridPanel() {

	}

	public void initBookTable(List<BookDto> dtoList) {
		clear();
		ListDataProvider<BookDto> bookDtoListDataProvider = new ListDataProvider<>();
		table = new CellTable(KEY_PROVIDER);
		Column<BookDto, String> idColumn = new TextColumn<BookDto>() {
			@Override
			public String getValue(BookDto object) {
				return object.getUid().toString();
			}
		};
		Column<BookDto, String> nameColumn = new TextColumn<BookDto>() {
			@Override
			public String getValue(BookDto object) {
				return object.getName();
			}
		};
		Column<BookDto, String> dateColumn = new TextColumn<BookDto>() {
			@Override
			public String getValue(BookDto object) {
				return object.getDate().toString();
			}
		};
		Column<BookDto, String> descColumn = new TextColumn<BookDto>() {
			@Override
			public String getValue(BookDto object) {
				return object.getDesc();
			}
		};
		table.addColumn(idColumn, "id");
		table.addColumn(nameColumn, "name");
		table.addColumn(dateColumn, "date");
		table.addColumn(descColumn, "desc");
		bookDtoListDataProvider.setList(dtoList);
		bookDtoListDataProvider.addDataDisplay(table);
		add(table);
	}

	public void initAuthorTable(List<AuthorDto> dtoList) {
		clear();
		ListDataProvider<AuthorDto> authorDtoListDataProvider = new ListDataProvider<>();
		table = new CellTable(KEY_PROVIDER);
		Column<AuthorDto, String> idColumn = new TextColumn<AuthorDto>() {
			@Override
			public String getValue(AuthorDto object) {
				return object.getUid().toString();
			}
		};
		Column<AuthorDto, String> firstNameColumn = new TextColumn<AuthorDto>() {
			@Override
			public String getValue(AuthorDto object) {
				return object.getFirstName();
			}
		};
		Column<AuthorDto, String> lastNameColumn = new TextColumn<AuthorDto>() {
			@Override
			public String getValue(AuthorDto object) {
				return object.getLastName();
			}
		};
		table.addColumn(idColumn, "id");
		table.addColumn(firstNameColumn, "name");
		authorDtoListDataProvider.setList(dtoList);
		authorDtoListDataProvider.addDataDisplay(table);
		add(table);
	}

	public void initPublisherTable(List<PublisherDto> dtoList) {
		clear();
		ListDataProvider<PublisherDto> dataProvider = new ListDataProvider<>();
		table = new CellTable(KEY_PROVIDER);
		Column<PublisherDto, String> idColumn = new TextColumn<PublisherDto>() {
			@Override
			public String getValue(PublisherDto object) {
				return object.getUid().toString();
			}
		};
		Column<PublisherDto, String> nameColumn = new TextColumn<PublisherDto>() {
			@Override
			public String getValue(PublisherDto object) {
				return object.getName();
			}
		};
		Column<PublisherDto, String> addressColumn = new TextColumn<PublisherDto>() {
			@Override
			public String getValue(PublisherDto object) {
				return object.getAddress();
			}
		};
		table.addColumn(idColumn, "id");
		table.addColumn(nameColumn, "name");
		table.addColumn(addressColumn, "address");
		dataProvider.setList(dtoList);
		dataProvider.addDataDisplay(table);
		add(table);
	}

	public void initLanguageTable(List<LanguageDto> dtoList) {
		clear();
		ListDataProvider<LanguageDto> dataProvider = new ListDataProvider<>();
		table = new CellTable(KEY_PROVIDER);
		Column<LanguageDto, String> idColumn = new TextColumn<LanguageDto>() {
			@Override
			public String getValue(LanguageDto object) {
				return object.getUid().toString();
			}
		};
		Column<LanguageDto, String> nameColumn = new TextColumn<LanguageDto>() {
			@Override
			public String getValue(LanguageDto object) {
				return object.getName();
			}
		};
		table.addColumn(idColumn, "id");
		table.addColumn(nameColumn, "name");
		dataProvider.setList(dtoList);
		dataProvider.addDataDisplay(table);
		add(table);
	}
}
