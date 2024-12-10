import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KataModalComponent } from './kata-modal.component';

describe('KataModalComponent', () => {
  let component: KataModalComponent;
  let fixture: ComponentFixture<KataModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [KataModalComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(KataModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
