import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KataPageComponent } from './kata-page.component';

describe('KataPageComponent', () => {
  let component: KataPageComponent;
  let fixture: ComponentFixture<KataPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [KataPageComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(KataPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
