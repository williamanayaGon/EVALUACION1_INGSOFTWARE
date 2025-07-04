import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CountryFormComponent } from './country-form.component';

describe('CountryFormComponent', () => {
  let component: CountryFormComponent;
  let fixture: ComponentFixture<CountryFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CountryFormComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CountryFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
